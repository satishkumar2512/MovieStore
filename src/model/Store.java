package model;

import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public Movie getMovie(String name)
    {
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name))
            {
                return new Movie(this.movies.get(i));
            }
        }
        return null;
        }
    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    public void action(String name, String action) {
        if (movies.isEmpty())
        {
            throw new IllegalArgumentException("Store is not in a valid state to perform action");
        }
        if(!(action.equals("sell") || action.equals("return") || action.equals("rent")))
        {
            throw new IllegalArgumentException("action must be sell,rent,return");
        }
        if(name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null pr blank");
        }
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name)) {
                switch (action) {
                    case "sell":
                        if (movies.get(i).getName().equals(name))
                        {
                            throw new IllegalArgumentException("cannot sell movie that was rented out");
                        }
                        this.movies.remove(i);break;
                    case "rent":
                        this.movies.get(i).setAvailable(false);break;
                    case "return":
                        this.movies.get(i).setAvailable(false);break;
                }
            }
        }
    }

    public String toString()
    {
        String temp = " ";
        for (int i=0;i<this.movies.size();i++)
        {
            temp +=this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }
    public void rentMovie(String name)
    {
        for (int i=0;i<this.movies.size();i++)
        {
            if(this.movies.get(i).getName().equals(name))
            {
                this.movies.remove(i);
            }
        }
    }
}
