package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private UserInformationServiceRule userInformationService;
    private OrderServiceRule orderService;
    private RepositoryServiceRule repositoryService;

    ProductOrderService
            (UserInformationServiceRule userInformationService, OrderServiceRule orderService, RepositoryServiceRule repositoryService) {
        this.userInformationService = userInformationService;
        this.orderService = orderService;
        this.repositoryService = repositoryService;
    }
    public SaleDto process(final SellRequest sellRequest) {

        BuildingRepositoryService buildingRepositoryService = new BuildingRepositoryService();

        if (buildingRepositoryService.saveOrder(sellRequest.getUser(), sellRequest.getOrder())) {
            orderService.sell(sellRequest.getUser(), sellRequest.getOrder());
            System.out.println("Confirm selling process succesfull");
            userInformationService.informUser(sellRequest.getUser());
            return new SaleDto(sellRequest.getUser(), true);

        } else {
            System.out.println("error while selling the product");
            return new SaleDto(sellRequest.getUser(), false);
        }
    }
}


