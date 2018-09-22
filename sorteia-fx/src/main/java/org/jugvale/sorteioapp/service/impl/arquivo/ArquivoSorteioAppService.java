package org.jugvale.sorteioapp.service.impl.arquivo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jugvale.sorteioapp.service.SorteioAppService;

public class ArquivoSorteioAppService implements SorteioAppService {

    private static final String DADOS_PARTICIPANTES = "/dados/participantes";

    private List<Object> nomes = new ArrayList<>();

    public ArquivoSorteioAppService() {
        try {
            Path path = Paths.get(ArquivoSorteioAppService.class.getResource(DADOS_PARTICIPANTES).toURI());
            Files.lines(path).forEach(nomes::add);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            System.out.println("Problema carregando " + DADOS_PARTICIPANTES + ". Retornando 0 valores");
        }
    }

    @Override
    public List<Object> buscaValores() {
        return nomes;
    }

}
