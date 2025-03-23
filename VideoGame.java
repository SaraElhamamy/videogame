import java.time.Year;
import java.util.Objects;
/**
 * Author: Sara Elhamamy
 * Date: March 20, 2025.
 * Purpose: Defines a VideoGame object with attributes such as title, platform, year, and prices.
 * This class includes constructors, validation in setters, and overridden methods.
 */
public class VideoGame {
    private static final double MARK_UP = 0.20;
    private String platform;
    private String title;
    private int year;
    private double wholesaleCost;
    private double retailPrice;

    // default
    public VideoGame() {
        this.platform = "";
        this.title = "";
        this.year = 1970;
        this.wholesaleCost = 0.0;
        this.retailPrice = 0.0;
    }

    // parameterized constructor
    public VideoGame(String title, String platform, int year, double wholesaleCost ) {
        this.platform = platform;
        this.title = title;
        this.year = year;
        this.wholesaleCost = wholesaleCost;
        this.retailPrice = retailPrice;
    }

    // copy constructor
    public VideoGame(VideoGame other) {
        this.title = other.title;
        this.platform = other.platform;
        this.year = other.year;
        this.wholesaleCost = other.wholesaleCost;
        this.retailPrice = other.retailPrice;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        if (platform == null || platform.trim().isEmpty()) {
            throw new IllegalArgumentException("Platform cannot be empty.");
        }
        this.platform = platform;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1970 || year > currentYear) {
            throw new IllegalArgumentException("Year must be between 1970 and " + currentYear + ".");
        }
        this.year = year;
    }

    public double getWholesaleCost() {
        return wholesaleCost;
    }

    public void setWholesaleCost(double wholesaleCost) {
        if (wholesaleCost < 0) {
            throw new IllegalArgumentException("Wholesale cost cannot be negative.");
        }
        this.wholesaleCost = wholesaleCost;
        this.retailPrice = wholesaleCost * (1 + MARK_UP); // Calculate retail price
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    @Override
    public String toString() {
        return String.format("Title: %-30s Platform: %-20s Year: %-10d Wholesale Cost: $%-6.2f Retail Price: $%-6.2f",
                title, platform, year, wholesaleCost, retailPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VideoGame videoGame = (VideoGame) o;
        return year == videoGame.year && Double.compare(wholesaleCost,
                videoGame.wholesaleCost) == 0 && Double.compare(retailPrice,
                videoGame.retailPrice) == 0 && Objects.equals(platform, videoGame.platform) && Objects.equals(title,
                videoGame.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platform, title, year, wholesaleCost, retailPrice);
    }
}
