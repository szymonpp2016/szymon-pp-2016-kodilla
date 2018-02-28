package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.networks.TwitterPublisher;

class ZGeneration extends User {

    ZGeneration(String name) {
        super(name);
        this.socialPublisher= new TwitterPublisher();

    }
}
