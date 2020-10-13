public void generateContactsListByCityAndState() {
	Set<String> cityNames = contacts.stream().map(contact ->
	contact.getAddress()).collect(Collectors.toSet());
	Set<String> stateNames = contacts.stream().map(contact ->
	contact.getState()).collect(Collectors.toSet());
	this.cityToContactsMap = cityNames.stream().collect(Collectors.toMap(cityName ->
	cityName, cityName -> {
		return contacts.stream().filter(contact ->
		contact.getAddress().equals(cityName)).sorted((c1, c2) -> {
			return c1.getFirstName().compareTo(c2.getFirstName());
		}).collect(Collectors.toList());
	}));
	this.stateToContactsMap =
			stateNames.stream().collect(Collectors.toMap(stateName -> stateName, stateName -> {
				return contacts.stream().filter(contact ->
				contact.getState().equals(stateName)).sorted((c1, c2) -> {
					return c1.getFirstName().compareTo(c2.getFirstName());
				}).collect(Collectors.toList());
			}));
}
public static void viewPersonsByCityOrState() {
	System.out.println("Choose \n1 To view by city\n2 To view by state\nEnter your
			choice: ");
				String option = (Integer.parseInt(sc.nextLine()) == 1) ? CITY : STATE;
	nameToAddressBookMap.keySet().stream().forEach(addressBookName -> {
		AddressBookMain addressBook =
				nameToAddressBookMap.get(addressBookName);
		addressBook.generateContactsListByCityAndState();
		System.out.println("In the address book " + addressBookName);
		System.out.println("");
		(option == CITY ? addressBook.cityToContactsMap.keySet() :
			addressBook.stateToContactsMap.keySet()).stream()
		.forEach(cityOrStateName -> {
			System.out.println(option + ": " + cityOrStateName);
			(option == CITY ?
					addressBook.cityToContactsMap.get(cityOrStateName)
					:
						addressBook.stateToContactsMap.get(cityOrStateName)).stream()
			.forEach(contact ->
			System.out.println(contact));
			System.out.println("");
		});
		System.out.println("");
	});
}
