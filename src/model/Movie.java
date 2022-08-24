package model;

public class Movie
{
        private String name;
        private String format;
        private double rating;
        private double sellingPrice;
        private double rentalPrice;
        public boolean isAvailable;
        private final static String FORMAT_DVD = "DVD";
        private final static String FORMAT_BLUERAY ="Blue-Ray";
    public Movie(String name, String format, double rating, double sellingPrice, boolean isAvailable)
    {
        if(name== null || name.isBlank())
        {
            throw new IllegalArgumentException("Name Must contain a value");
        }
        if(!(format.equals(FORMAT_DVD)|| format.equals(FORMAT_BLUERAY)))
        {
            throw new IllegalArgumentException("Format Must be DVD or Blue-Ray");
        }
        if(rating<0 || rating >10)
        {
        throw new IllegalArgumentException("Invalid Rating");
        }
      this.name=name;
      this.format=format;
      this.rating=rating;
      this.sellingPrice=format.equals(FORMAT_BLUERAY)?4.25:2.25;
      this.rentalPrice=format.equals(FORMAT_BLUERAY)?1.99:0.99;
      this.isAvailable=true;
    }
    public Movie(Movie source)
    {
        this.name=source.name;
        this.format=source.format;
        this.rating=source.rating;
        this.sellingPrice=source.sellingPrice;
        this.rentalPrice=source.rentalPrice;
        this.isAvailable=source.isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public double getRating() {
        return rating;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setName(String name) {
        if(name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name cannot be null or Blank");
        }
        this.name = name;
    }

    public void setFormat(String format) {
        if(!(format.equals(FORMAT_DVD)|| format.equals("Blue-Ray")))
        {
            throw new IllegalArgumentException("Format Must be DVD or Blue-Ray");
        }
        this.format = format;
        setSellingPrice(format.equals(FORMAT_BLUERAY)? 4.25:2.25);
        setRentalPrice(format.equals(FORMAT_BLUERAY)?1.99:0.99);
    }

    public void setRating(double rating) {
        if(rating<0 || rating >10)
        {
            throw new IllegalArgumentException("Invalid Rating");
        }
        this.rating = rating;
    }

    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public String toString()
    {
        return "\t Name: " + this.name + "\n" +

                "\t Format: " + this.format + "\n" +

                "\t Rating: " + this.rating + "\n" +

                "\t Selling Price: " + this.sellingPrice + "\n" +

                "\t Rental Price: " + this.rentalPrice + "\n" +

                "\t Availability: " + this.isAvailable + "\n";
    }
}
