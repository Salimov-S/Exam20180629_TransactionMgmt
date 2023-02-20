package transactions;

public class Offer {

    private String offerID;
    private String placeName;
    private String productID;

    public Offer(String offerID, String placeName, String productID) {
        this.offerID = offerID;
        this.placeName = placeName;
        this.productID = productID;
    }

    public String getOfferID() {
        return offerID;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getProductID() {
        return productID;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offerID='" + offerID + '\'' +
                ", placeName='" + placeName + '\'' +
                ", productID='" + productID + '\'' +
                '}';
    }
}
