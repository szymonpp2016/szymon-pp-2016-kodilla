package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.networks.FacebookPublisher;

class Millenials extends User {

    Millenials(String name) {
        super(name);
        this.socialPublisher= new FacebookPublisher();
    }
}
