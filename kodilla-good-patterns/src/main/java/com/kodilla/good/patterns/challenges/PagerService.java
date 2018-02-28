package com.kodilla.good.patterns.challenges;

 class PagerService implements UserInformationServiceRule {

   public void informUser(User user) {
        System.out.println("Sending confirmation (pager service) to " + user.getName() + " " + user.getSurname()+".");
   }
}
