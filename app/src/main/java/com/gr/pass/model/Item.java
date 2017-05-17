package com.gr.pass.model;

public class Item {

    private String itemId;
    private String company;
    private String price;
    private String material;
    private String category;
    private String color;
    private String size;
    private String detail;
    private String wash;

    public Item(String itemId, String company, String price, String material, String category, String color, String size, String detail, String wash) {
        this.itemId = itemId;
        this.company = company;
        this.price = price;
        this.material = material;
        this.category = category;
        this.color = color;
        this.size = size;
        this.detail = detail;
        this.wash = wash;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getMaterial()
    {
        return material;
    }

    public void setMaterial(String material)
    {
        this.material = material;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getWash() {
        return wash;
    }

    public void setWash(String wash) {
        this.wash = wash;
    }
}
