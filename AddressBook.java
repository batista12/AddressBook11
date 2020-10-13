public class AddressBookMain {
	private int numOfContact = 0;
	private ContactDetails[] contactArray;
	private AddressBookMain() {
		contactArray = new ContactDetails[5];
	}
	private void addContactDetails(String firstName, String lastName, String address, String
			state, int zip, long phoneNo, String emailId) {
		contactArray[numOfContact] = new ContactDetails();
		contactArray[numOfContact].setContactDetails(firstName, lastName, address, state,
				zip, phoneNo, emailId);
		numOfContact++;
	}
	private void editContactDetails(String firstName, String lastName, String address, String
			state, int zip, long phoneNo, String emailId) {
		for(int i = 0; i < numOfContact; i++) {
			if(contactArray[i].firstName.equals(firstName) &&
					contactArray[i].lastName.equals(lastName)) {
				contactArray[i].setContactDetails(firstName, lastName, address,
						state, zip, phoneNo, emailId);
				System.out.println("Address changed");
				System.out.println(contactArray[i]);
				break;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBookMain addressBook = new AddressBookMain();
		System.out.println("No. of contact details to enter (upto 5): ");
		int numOfContact = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < numOfContact; i++) {
			System.out.println("First Name: ");
			String firstName = sc.nextLine();
			System.out.println("Last Name: ");
			String lastName = sc.nextLine();
			System.out.println("Address: ");
			String address = sc.nextLine();
			System.out.println("State: ");
			String state = sc.nextLine();
			System.out.println("ZIP: " );
			int zip = sc.nextInt();
			System.out.println("Phone No: ");
			long phoneNo = sc.nextLong();
			sc.nextLine();
			System.out.println("Email ID: ");
			String emailId = sc.nextLine();
			addressBook.addContactDetails(firstName, lastName, address, state, zip,
					phoneNo, emailId);
		}
		System.out.println("Enter details for contact record you want to edit");
		System.out.println("First Name: ");
		String firstName = sc.nextLine();
		System.out.println("Last Name: ");
		String lastName = sc.nextLine();
		System.out.println("Address: ");
		String address = sc.nextLine();
		System.out.println("State: ");
		String state = sc.nextLine();
		System.out.println("ZIP: " );
		int zip = sc.nextInt();
		System.out.println("Phone No: ");
		long phoneNo = sc.nextLong();
		sc.nextLine();
		System.out.println("Email ID: ");
		String emailId = sc.nextLine();
		addressBook.editContactDetails(firstName, lastName, address, state, zip, phoneNo, emailId);
	}
}
public class ContactDetails {
	public String firstName;
	public String lastName;
	private String address; //address components don't have to be used so declaring as string
	rather than string array
	private String state;
	private int zip;
	private long phoneNo;
	private String emailId;
	public void setContactDetails(String firstName, String lastName, String address, String state,
			int zip, long phoneNo, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + " Address: " + address + " State: " + state + " Zip: " +
				zip + " Phone No: " + phoneNo + " Email: " + emailId;
	}
}
