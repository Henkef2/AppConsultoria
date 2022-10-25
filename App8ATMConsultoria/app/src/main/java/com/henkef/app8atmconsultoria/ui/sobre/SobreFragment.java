package com.henkef.app8atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.henkef.app8atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SobreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SobreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SobreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SobreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SobreFragment newInstance(String param1, String param2) {
        SobreFragment fragment = new SobreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sobre, container, false);
        String descrição = "A ATM Consultoria tem como missão apoiar organizações que desejam " +
                "alcançar o sucesso atráves da excelência em gestão e da busca pela qualidade";

        Element versao = new Element();
        versao.setTitle( "Versão 1.0");

        return new AboutPage( getActivity() )  //obs se estivesse dentro do main activity poderia utilizar somente o "this" porém como estou dentro de um fragment, para buscar a activity preciso digitar "getActiviti()"
                .setImage( R.drawable.logo )
                .setDescription(descrição)

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um e-mail")
                .addWebsite("https://www.google.com/", "Acesse nosso site")

                .addGroup("Redes Sociais")
                .addFacebook("PH.Studio.Dev", "Facebook")
                .addInstagram("PH.Studio.Dev", "Instagram")
                .addTwitter("PH.Studio.Dev", "Twitter")
                .addYoutube("PH.Studio.Dev", "YouTube")
                .addGitHub("Henkef2", "GitHub")
                .addPlayStore("com.henkef.frasesdodia", "Download App")

                .addItem(versao)

                .create();
    }
}