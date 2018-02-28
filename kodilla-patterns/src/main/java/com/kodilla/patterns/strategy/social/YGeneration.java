package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.networks.SnapchatPublisher;

class YGeneration extends User {

    YGeneration(String name) {
        super(name);
        this.socialPublisher= new SnapchatPublisher();
    }
}
