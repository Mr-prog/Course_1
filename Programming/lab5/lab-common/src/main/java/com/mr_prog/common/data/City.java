package com.mr_prog.common.data;

import java.time.LocalDate;

public class City implements Validatable {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Double area; //Значение поля должно быть больше 0, Поле не может быть null
    private final Long population; //Значение поля должно быть больше 0, Поле не может быть null
    private final Long metersAboveSeaLevel;
    private double agglomeration;
    private final Government government; //Поле может быть null
    private final StandardOfLiving standardOfLiving; //Поле не может быть null
    private final Human governor; //Поле может быть null

    public City(String name, Coordinates coordinates, LocalDate localDate, Double area, Long population, Long metersAboveSeaLevel,
                double agglomeration, Government government, StandardOfLiving standardOfLiving, Human governor) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = localDate;
        this.area = area;
        this.population = population;
        this.metersAboveSeaLevel = metersAboveSeaLevel;
        this.agglomeration = agglomeration;
        this.government = government;
        this.standardOfLiving = standardOfLiving;
        this.governor = governor;


    }

    public String getName() {
        return name;
    }

    public Double getArea() {
        return area;
    }

    public double getAgglomeration() {
        return agglomeration;
    }

    public Integer getId() {
        return id;
    }

    public Long getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }

    public StandardOfLiving getStandardOfLiving() {
        return standardOfLiving;
    }

    public void setAgglomeration(double agglomeration) {
        this.agglomeration = agglomeration;
    }

    public Long getPopulation() {
        return population;
    }

    public Government getGovernment() {
        return government;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }




    @Override
    public boolean validate() {
        return (governor != null & standardOfLiving != null
        & government != null & population > 0
        & area > 0 & creationDate != null & coordinates.validate()
        & name != null & !name.equals("") & id > 0);
    }
}
