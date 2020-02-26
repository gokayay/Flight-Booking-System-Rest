package com.airlines.automationsystem.constant;

public interface ConstantStrings {

    interface Query {

        final String getAirportBySearch = "select * from airports where lower(airport_name) like lower(concat('%',:airport_name,'%'))";

        final String getCompanyBySearch = "select * from companies where lower(company_name) like lower(concat('%',:company_name,'%'))";

    }
}
