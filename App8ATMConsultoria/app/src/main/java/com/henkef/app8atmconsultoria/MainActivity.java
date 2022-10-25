package com.henkef.app8atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.henkef.app8atmconsultoria.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre
        )
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

        String celular = "tel:61997788445";
        String imagem = "https://www.viagenscinematograficas.com.br/wp-content/uploads/2019/01/Praia-do-Espelho-Dicas-Bahia-13.jpg";
        String endereco = "https://www.google.com/maps/place/Parque+Ibirapuera/@-23.5953485,-46.6667097,15z/data=!4m6!3m5!1s0x94ce59f1069d11d1:0xcb936109af9ce541!8m2!3d-23.5874162!4d-46.6576336!16zL20vMDk3X3E2";
        //Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse(celular));  //aqui foi definido uma intenção de fazer uma ação, que é o ACTION_DIAL, essa ação é digitado um numero para ligar a partir do programa de ligações do aparelho. Mas a ligação não é feita
        //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(imagem));  //aqui foi definido para abrir a imagem do endereço colado acima
        //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(endereco)); //aqui foi definido para abrir um endereço do google maps, então vai abrir diretamente do app google maps

        Intent intent = new Intent( Intent.ACTION_SEND);

        intent.putExtra( Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"} );
        intent.putExtra( Intent.EXTRA_SUBJECT, "Contato pelo App" );
        intent.putExtra( Intent.EXTRA_TEXT, "Mensagem automática" );

        intent.setType("message/rfc822");  //abre aplicativos de email para escolher
        //intent.setType("text/plain");  //abre diversas opções, como app de email, compartilhar via bluethoot, copiar, etc
        //intent.setType("image/*");  //define qualquer tipo de imagem
        //intent.setType("application/pdf"); //define para abrir um app leitor de PDF. / esse site contem a lista completa das ações https://www.sitepoint.com/mime-types-complete-list/

        startActivity( Intent.createChooser( intent, "Compartilhar") );
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}