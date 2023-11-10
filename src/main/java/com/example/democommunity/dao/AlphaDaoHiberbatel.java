package com.example.democommunity.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphaDaoHiberbatel implements AlphaDao{
    @Override
    public String select() {
        return "Hiberbatel";
    }
}
