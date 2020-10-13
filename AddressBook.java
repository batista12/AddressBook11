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
	public void addContact() {
		do {
			System.out.println("Enter the contact details in the given
					order:\nfirstname\nlastname");
					ContactDetails checkContact = new ContactDetails(sc.nextLine(),
							sc.nextLine());
			if (contacts.stream().anyMatch(contact -> contact.equals(checkContact))) {
				System.out.println("Same entry already present.");
			} else {
				System.out.println(
						"Enter the contact details in the given
						order:\nfirstname\nlastname\naddress\nstate\nzip\nphone no.\nemail");
						ContactDetails newContact = new ContactDetails(sc.nextLine(),
								sc.nextLine(), sc.nextLine(),sc.nextLine(),
								Integer.parseInt(sc.nextLine()),
								Long.parseLong(sc.nextLine()), sc.nextLine());
				this.contacts.add(newContact);
				this.nameToContactMap.put(newContact.getFirstName() + " " +
						newContact.getLastName(), newContact);
			}
			System.out.println("Enter 1 to add another contact, else enter 0: ");
		} while (Integer.parseInt(sc.nextLine()) == 1);
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
