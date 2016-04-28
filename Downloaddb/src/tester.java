import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sosv.breweryDB.connector.entity.beer.Beer;
import com.sosv.breweryDB.connector.guice.BreweryDBAsyncModule;
import com.sosv.breweryDB.connector.service.IBreweryDBService;
import com.sosv.breweryDB.connector.service.exceptions.ApiKeyNotFoundExeption;
import com.sosv.breweryDB.connector.service.resource.filter.beer.BeersFilter;

public class tester {

	public static void main(String[] args) throws ApiKeyNotFoundExeption {
		System.out.println("start");

		// Create the injector, the async module creates the sync and async
		// object
		Injector injector = Guice.createInjector(new BreweryDBAsyncModule());

		// Get the sync service
		final IBreweryDBService syncService = injector.getInstance(IBreweryDBService.class);
		// Do some sync calls

		 //Get beers by name
		
//		List<Beer> allB= syncService.getAllBeers(BeersFilter.createNameFilter("Tropical Snow Dance IPA"));
//		for (Beer beer : allB) {
//			System.out.println("Test: " + beer);
//		}
		
		 List<Brewery> allBrew= syncService.getAllBreweries();
		 for (Brewery brewery : allBrew) {
			System.out.println("THIS: " + brewery);
		}
		 
		 System.out.println("Done");
	}

//	public class PropertyBreweryDBConnectorConfiguration implements IBreweryDBConnectorConfiguration {
//
//		private String apiKey;
//
//		public PropertyBreweryDBConnectorConfiguration() throws IOException {
//			super();
//			Properties prop = new Properties();
//			InputStream stream = getClass().getResourceAsStream("/configuration.properties");
//			prop.load(stream);
//			this.apiKey = (String) prop.get("apiKey");
//			
//		}
//
//		@Override
//		public String getApiKey() {
//			return apiKey;
//		}

		// // Get the async service
		// final IBreweryDBServiceAsync asyncService = injector
		// .getInstance(IBreweryDBServiceAsync.class);
		//
		// // Do some async calls
		// asyncService.getAllBeers(new IResultCallback<List<Beer>>() {
		//
		// public void onSuccess(List<Beer> result) {
		// System.out.println(result);
		// }
		//
		// public void onError(Throwable throwable) {
		// throwable.printStackTrace();
		// }
		// });
		//
		// asyncService.getBeerById("cBLTUw", new IResultCallback<Beer>() {
		//
		// public void onSuccess(Beer result) {
		// System.out.println("Async:" + result);
		// }
		//
		// public void onError(Throwable throwable) {
		// throwable.printStackTrace();
		// }
		// });

	}


