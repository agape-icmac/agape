package br.com.agape.enums;

public class UrlEnum {

    public enum GestaoFrontEnd {

        NOME("Bitscamp"),
        URL_DEV("http://localhost:63343/agape-icmac.github.io"),
        URL_PROD("https://agape-icmac.github.io");

        private String descricao;

        GestaoFrontEnd(String descricao) {
            this.descricao = descricao;
        }

        public String getNome() {
            return NOME.descricao;
        }

        public String getUrl() {
            return this.descricao;
        }
    }


}
