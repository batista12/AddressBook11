public static void countByCityAndState() {
	
	nameToAddressBookMap.keySet().stream().forEach(addressBookName -> {
		AddressBookMain addressBook =
				nameToAddressBookMap.get(addressBookName);
		System.out.println("In the address book " + addressBookName);
		System.out.println("");
		System.out.println("Contact counts by city");
		addressBook.cityToContactsMap.keySet().stream().forEach(
				cityName -> System.out.println(cityName + ": " +
						addressBook.cityToContactsMap.get(cityName).size()));
		System.out.println("\nContact counts by state");
		addressBook.stateToContactsMap.keySet().stream().forEach(
				stateName -> System.out.println(stateName + ": " +
						addressBook.stateToContactsMap.get(stateName).size()));
		System.out.println("");
	});
}
public static void addAddressBooks() {
	int choice = 1;
	while (choice == 1) {
		System.out.println("Enter your choice 1 or 0 or 2: ");
		choice = Integer.parseInt(sc.nextLine());
		if (choice == 1) {
			System.out.println("Enter name of the address book");
			String name = sc.nextLine();
			nameToAddressBookMap.put(name, new
					AddressBookMain(name));
		} else if (choice == 2)
			break;
		else {
			System.out.println("Invalid");
		}
	}
}
public static void main(String[] args) {
	addAddressBooks();
	do {
		System.out.println("Enter the name of the address book to continue: ");
		AddressBookMain addressBook =
				nameToAddressBookMap.get(sc.nextLine());
		addressBook.addContact();
		System.out.println(addressBook);
		System.out.println("Enter 1 to continue with another address book, else
				enter 0: ");
	} while (Integer.parseInt(sc.nextLine()) == 1);
	getPersonsByCityOrState();
	viewPersonsByCityOrState();
	countByCityAndState();
	sc.close();
}
}
public class ContactDetails {
	private String firstName;
	private String lastName;
	private String address;
	private String state;
	private int zip;
	private long phoneNumber;
	private String email;
	public ContactDetails(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public ContactDetails(String firstName, String lastName, String address, String state, int zip,
			long phoneNumber,
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + " Address: " + address + " State: " +
				state + " Zip: " + zip
				+ " Phone No: " + phoneNumber + " Email: " + email;
	}
	@Override
	public boolean equals(Object obj) {
		ContactDetails checkContact = (ContactDetails) obj;
		return (checkContact.getFirstName().equals(this.firstName))
				&& (checkContact.getLastName().contentEquals(this.lastName));
	}
}
