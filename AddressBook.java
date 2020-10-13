import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	public static String bookname;
	public static String name;
	public List<ContactDetails> contacts;
	public Map<String, ContactDetails> nameToContactMap;
	public AddressBookMain(String name) {
		super();
		this.bookname = name;
		this.contacts = new LinkedList<ContactDetails>();
		this.nameToContactMap = new LinkedHashMap<String, ContactDetails>();
	}
	public static void getPersonsByCityOrState() {
System.out.println("Choose \n1 To search by city\n2 To search by state\nEnter your
choice: ");
String option = (Integer.parseInt(sc.nextLine()) == 1) ? CITY : STATE;
System.out.println("Enter the name of " + option + ": ");
String cityOrStateName = sc.nextLine();
nameToAddressBookMap.keySet().stream().forEach(addressBookName -> {
AddressBookMain addressBook =
nameToAddressBookMap.get(addressBookName);
System.out.println("Persons in the " + option + " " + cityOrStateName + " in
the address book "
+ addressBookName + " are: ");
addressBook.contacts.stream().filter(
contact -> ((option == CITY ? contact.getAddress() :
contact.getState()).equals(cityOrStateName)))
.forEach(contact -> System.out.println(contact));
System.out.println("");
});
}
	public static void main(String[] args) {
		System.out.println("Enter the name of the addressbook:");
		String book = sc.nextLine();
		AddressBookMain addressBook = new AddressBookMain(bookname);
		addressBook.addContact();
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
