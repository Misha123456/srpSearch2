package my.project;


import my.project.configs.WildBerriesRequest;

public class Main {

    public static void main(String[] args) {
        final String srpUrl = "https://www.wildberries.by/catalog/aksessuary/bandany";
        final String pdpLineElementSelector = ".catalog_main_table.j-products-container .dtList.i-dtList.j-card-item .ref_goods_n_p";
        final WildBerriesRequest wildBerriesRequest = new WildBerriesRequest(srpUrl, pdpLineElementSelector);

        new SrpMatcher().match(wildBerriesRequest);
    }


}
