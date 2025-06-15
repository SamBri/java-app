package com.app.performance;

import java.awt.Point;
import java.lang.reflect.Field;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// listingB
/*
 startTime:1750025373619
Product [id=1, name=iPhone 13, productId=139a2528-f85a-4a82-b660-a7c255651fe3, prodCatId=DEVICE]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
found!
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=2, name=Macbook pro, productId=cbbd8063-c9fc-445a-9c6a-46a8db906804, prodCatId=DEVICE]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
found!
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=3, name=White Rice, productId=73e27c70-5fc4-4aa0-9a4e-4fc81cefc5e8, prodCatId=FOOD]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=4, name=Electric Iron, productId=7e16adae-84f8-428b-a88c-7bb7bc644d7b, prodCatId=APPLIANCE]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=5, name=Watermelon, productId=0c4aebad-b35a-4131-aa07-564cf5d84785, prodCatId=FOOD]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=6, name=Wardrobe, productId=4187192a-a98c-4bd7-afbc-083bfc6c7111, prodCatId=FURNITURE]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=7, name=Samsung galaxy A12, productId=1ff14cd1-9a9c-4359-ba1c-46dba7f8379b, prodCatId=DEVICE]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
found!
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=8, name=Belaire Rose, productId=1ccc75f7-ad66-439a-b7fa-814d49b4fc76, prodCatId=DRINK]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=9, name=Coca-cola, productId=8fcfd136-3281-43eb-b167-1057c5fd822e, prodCatId=DRINK]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=10, name=Xiamoi, productId=729cc289-df85-4552-9e9d-e80967a506cc, prodCatId=DEVICE]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
found!
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=11, name=Nokia 3310, productId=0139cb0d-5998-4e4d-839f-5d5f2053de1d, prodCatId=DEVICE]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
found!
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=12, name=Voltic Water, productId=ca9c5b7c-39d4-4827-9037-e944adba951a, prodCatId=DRINK]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=13, name=Cool pac Water, productId=0127c741-133a-427e-88db-428712355ae7, prodCatId=DRINK]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=14, name=BelAqua Water, productId=a9b39bd7-9969-4999-8ce7-c555202ea764, prodCatId=DRINK]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=15, name=Smirn-off, productId=1c256af5-688a-4150-9322-a7cb461dca1e, prodCatId=DRINK]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=16, name=Donjulio, productId=685f688a-b85b-4888-806a-8b6a1bfa34d4, prodCatId=DRINK]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=17, name=iPhone 14, productId=9f50224e-0a61-4c50-9178-3b073b338a9b, prodCatId=DEVICE]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
found!
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=18, name=Samsung Galaxy S10, productId=85c1e9f0-b6d3-46d4-928c-6a2d48156b0e, prodCatId=DEVICE]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
found!
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=19, name=Broiled Chicken, productId=863d048e-7c2d-47fa-918d-c193302e8a04, prodCatId=FOOD]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
Product [id=20, name=Chicken Nuggets, productId=d60a8381-778e-484a-8dd9-7c73fe4bdf40, prodCatId=FOOD]
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
searching for productCategory :: DEVICE
Field is  :: APPLIANCE
searching for productCategory :: DEVICE
Field is  :: STATIONARY
searching for productCategory :: DEVICE
Field is  :: FURNITURE
endTime:1750025373625
time taken to gather devices : PT0.006S
number of devices 7
devices [Product [id=1, name=iPhone 13, productId=139a2528-f85a-4a82-b660-a7c255651fe3, prodCatId=DEVICE], Product [id=2, name=Macbook pro, productId=cbbd8063-c9fc-445a-9c6a-46a8db906804, prodCatId=DEVICE], Product [id=7, name=Samsung galaxy A12, productId=1ff14cd1-9a9c-4359-ba1c-46dba7f8379b, prodCatId=DEVICE], Product [id=10, name=Xiamoi, productId=729cc289-df85-4552-9e9d-e80967a506cc, prodCatId=DEVICE], Product [id=11, name=Nokia 3310, productId=0139cb0d-5998-4e4d-839f-5d5f2053de1d, prodCatId=DEVICE], Product [id=17, name=iPhone 14, productId=9f50224e-0a61-4c50-9178-3b073b338a9b, prodCatId=DEVICE], Product [id=18, name=Samsung Galaxy S10, productId=85c1e9f0-b6d3-46d4-928c-6a2d48156b0e, prodCatId=DEVICE]]
 */

// listingB
/*
 startTime:1750025488482
searching for productCategory :: DEVICE
Field is  :: FOOD
searching for productCategory :: DEVICE
Field is  :: DRINK
searching for productCategory :: DEVICE
Field is  :: DEVICE
found!
products are devices ::
device is not null
products are devices ::
device is not null
device is not null
device is not null
device is not null
device is not null
products are devices ::
device is not null
device is not null
device is not null
products are devices ::
device is not null
products are devices ::
device is not null
device is not null
device is not null
device is not null
device is not null
device is not null
products are devices ::
device is not null
products are devices ::
device is not null
device is not null
endTime:1750025488483
time taken to gather devices :PT0.001S
number of devices 7
devices [Product [id=1, name=iPhone 13, productId=176a4f62-b622-4ad6-8526-a49235b10067, prodCatId=DEVICE], Product [id=2, name=Macbook pro, productId=2deaf913-7f01-4ed1-a8f5-ed27ea309e85, prodCatId=DEVICE], Product [id=7, name=Samsung galaxy A12, productId=808f5fdb-a57e-45be-9b6f-f459e6d945a3, prodCatId=DEVICE], Product [id=10, name=Xiamoi, productId=c4b71a39-34d6-45b5-a7f8-4f1a9a6af582, prodCatId=DEVICE], Product [id=11, name=Nokia 3310, productId=af71f627-f26e-4905-9c6c-e81a9746f33c, prodCatId=DEVICE], Product [id=17, name=iPhone 14, productId=19ead4fe-fe25-4e08-a38b-cc091352185c, prodCatId=DEVICE], Product [id=18, name=Samsung Galaxy S10, productId=912fbc36-7154-48c3-88b0-1ace21042d0b, prodCatId=DEVICE]]
 */

public class App {

	public static void main(String[] args) {

		//listingB(); // time taken : [PT0.004S,PT0.004S,PT0.005S,PT0.003S,PT0.005S] - slower response time, degrading performance
		//listingA(); // time taken : [PT0.001S,PT0.001S,PT0.001S,PT0.001S,PT0.001S] - faster response time, better performance

	}

	// find devices from a list of categories
	private static void listingA() {

		Product[] products = { new Product(1L, "iPhone 13", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(2L, "Macbook pro", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(3L, "White Rice", UUID.randomUUID().toString(), ProductCategory.FOOD),
				new Product(4L, "Electric Iron", UUID.randomUUID().toString(), ProductCategory.APPLIANCE),
				new Product(5L, "Watermelon", UUID.randomUUID().toString(), ProductCategory.FOOD),
				new Product(6L, "Wardrobe", UUID.randomUUID().toString(), ProductCategory.FURNITURE),
				new Product(7L, "Samsung galaxy A12", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(8L, "Belaire Rose", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(9L, "Coca-cola", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(10L, "Xiamoi", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(11L, "Nokia 3310", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(12L, "Voltic Water", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(13L, "Cool pac Water", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(14L, "BelAqua Water", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(15L, "Smirn-off", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(16L, "Donjulio", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(17L, "iPhone 14", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(18L, "Samsung Galaxy S10", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(19L, "Broiled Chicken", UUID.randomUUID().toString(), ProductCategory.FOOD),
				new Product(20L, "Chicken Nuggets", UUID.randomUUID().toString(), ProductCategory.FOOD)

		};

		String DEVICE = null;
		List<Product> devices = null;

		long startTime = System.currentTimeMillis();
		System.out.println("startTime:" + Long.valueOf(startTime));
		for (Product product : products) {

			Field[] fields = ProductCategory.class.getFields();

			if (DEVICE == null) {
				for (Field field : fields) {

					System.out.println("searching for productCategory :: DEVICE");
					String productCategoryId = field.getName().toString();
					System.out.println("Field is  :: " + productCategoryId);

					if (productCategoryId.equals(ProductCategory.DEVICE.toString())) {

						System.out.println("found!");
						DEVICE = productCategoryId;
						devices = new ArrayList<>();
						break;
					}

				}
			} else {
				System.out.println("device is not null");
			}

			if (product.getProdCatId().toString().equals(DEVICE)) {

				System.out.println("products are devices ::");
				devices.add(product);

			}

		}

		long endTime = System.currentTimeMillis();
		System.out.println("endTime:" + Long.valueOf(endTime));
		System.out.println("time taken to gather devices :" + Duration.ofMillis(endTime - startTime));

		System.out.println("number of devices " + devices.size());
		System.out.println("devices " + devices.toString());

	}

	// find devices from a list of categories
	private static void listingB() {

		Product[] products = { new Product(1L, "iPhone 13", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(2L, "Macbook pro", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(3L, "White Rice", UUID.randomUUID().toString(), ProductCategory.FOOD),
				new Product(4L, "Electric Iron", UUID.randomUUID().toString(), ProductCategory.APPLIANCE),
				new Product(5L, "Watermelon", UUID.randomUUID().toString(), ProductCategory.FOOD),
				new Product(6L, "Wardrobe", UUID.randomUUID().toString(), ProductCategory.FURNITURE),
				new Product(7L, "Samsung galaxy A12", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(8L, "Belaire Rose", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(9L, "Coca-cola", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(10L, "Xiamoi", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(11L, "Nokia 3310", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(12L, "Voltic Water", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(13L, "Cool pac Water", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(14L, "BelAqua Water", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(15L, "Smirn-off", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(16L, "Donjulio", UUID.randomUUID().toString(), ProductCategory.DRINK),
				new Product(17L, "iPhone 14", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(18L, "Samsung Galaxy S10", UUID.randomUUID().toString(), ProductCategory.DEVICE),
				new Product(19L, "Broiled Chicken", UUID.randomUUID().toString(), ProductCategory.FOOD),
				new Product(20L, "Chicken Nuggets", UUID.randomUUID().toString(), ProductCategory.FOOD)

		};

		List<Product> devices = new ArrayList<>();

		long startTime = System.currentTimeMillis();
		System.out.println("startTime:" + Long.valueOf(startTime));
		for (Product product : products) {

			System.out.println(product);

			Field[] fields = ProductCategory.class.getFields();

			for (Field field : fields) {

				System.out.println("searching for productCategory :: DEVICE");
				String productCategoryId = field.getName().toString();
				System.out.println("Field is  :: " + productCategoryId);

				if (productCategoryId.equals(ProductCategory.DEVICE.toString())) {

					if (product.getProdCatId().toString().equals(productCategoryId.toString())) {
						System.out.println("found!");
						devices.add(product);

					}

				}

			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("endTime:" + Long.valueOf(endTime));
		System.out.println("time taken to gather devices : " + Duration.ofMillis(endTime - startTime));

		System.out.println("number of devices " + devices.size());
		System.out.println("devices " + devices.toString());

	}

}
