package transactions;

public class Request {

    public String requestID;
    public String placeName;
    public String productID;

    public Request(String requestID, String placeName, String productID) {
        this.requestID = requestID;
        this.placeName = placeName;
        this.productID = productID;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestID='" + requestID + '\'' +
                ", placeName='" + placeName + '\'' +
                ", productID='" + productID + '\'' +
                '}';
    }
}
