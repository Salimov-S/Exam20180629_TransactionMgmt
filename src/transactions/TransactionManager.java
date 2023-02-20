package transactions;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionManager {


	private Set<Region> regionSet = new TreeSet<>(new ByNameRegionComparator());
	private Set<Carrier> carrierSet = new TreeSet<>(new ByNameCarrierComparator());
	private List<Offer> offers = new ArrayList<>();
	private List<Request> requests = new ArrayList<>();
	 private List<String> placeNamesList = new ArrayList<>();

//R1
	public List<String> addRegion(String regionName, String... placeNames) {
		List<String> placeList = new ArrayList<>();
		Region region = new Region(regionName, placeNames);
		regionSet.add(region);
		for (String placeName : placeNames) {
			placeList.add(placeName);
			placeNamesList.add(placeName);
		}
		return placeList.stream().sorted().collect(Collectors.toList());
	}

	public List<String> addCarrier(String carrierName, String... regionNames) {
		List<String> carrierRegionList = new ArrayList<>();
		for (Region region : regionSet) {
			if (region.getRegionName().equals(regionNames)) {
				Carrier carrier = new Carrier(carrierName, regionNames);
				carrierSet.add(carrier);
				carrierRegionList.add(String.valueOf(regionNames));
			}
		}
		return carrierRegionList;
	}

	public List<String> getCarriersForRegion(String regionName) {
		List<String> carrierList = new ArrayList<>();
		for (Carrier carrier : carrierSet) {
			if (carrier.getCarrierName().equals(regionName)) {
				carrierList.add(carrier.getCarrierName());
			}
		}
		return carrierList;
	}

//R2
	public void addRequest(String requestId, String placeName, String productId)
			throws TMException {
		boolean placeNameExist = false;
		for (String place : placeNamesList) {
			if(place.equals(placeName)){
				placeNameExist=true;
			}
		}
		if (!placeNameExist) {
			throw new TMException("");
		}
		for (Request request : requests) {
			if (request.getRequestID().equals(requestId)) {
				throw new TMException("Duplicated");
			}
		}
		Request request = new Request(requestId, placeName, productId);
		requests.add(request);

	}

	public void addOffer(String offerId, String placeName, String productId)
			throws TMException {
		boolean placeNameExist = false;
		for (String place : placeNamesList) {
			if (place.equals(placeName)) {
                placeNameExist = true;
            }
		}
		if (!placeNameExist) {
			throw new TMException("");
		}
		for (Offer offer : offers) {
			if (offer.getOfferID().equals(offerId)) {
				throw new TMException("Duplicated");
			}
		}
		Offer offer = new Offer(offerId, placeName, productId);
		offers.add(offer);
	}


//R3
	public void addTransaction(String transactionId, String carrierName, String requestId, String offerId)
			throws TMException {
	}

	public boolean evaluateTransaction(String transactionId, int score) {
		return false;
	}

//R4
	public SortedMap<Long, List<String>> deliveryRegionsPerNT() {
		return new TreeMap<Long, List<String>>();
	}

	public SortedMap<String, Integer> scorePerCarrier(int minimumScore) {
		return new TreeMap<String, Integer>();
	}

	public SortedMap<String, Long> nTPerProduct() {
		return new TreeMap<String, Long>();
	}

	private static class ByNameRegionComparator implements Comparator<Region> {

		@Override
		public int compare(Region o1, Region o2) {
			return o1.getRegionName().compareTo(o2.getRegionName());
		}
	}

	private static class ByNameCarrierComparator implements Comparator<Carrier> {

		@Override
		public int compare(Carrier o1, Carrier o2) {
			return o1.getCarrierName().compareTo(o2.getCarrierName());
		}
	}
}

