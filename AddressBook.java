public class AddressBookMain {
	private String firstName;
	private String lastName;
	private String address;
	private String state;
	private String zip;
	private String phoneNo;
	private String emailId;
	public AddressBookMain (String firstName, String lastName, String address, String state, String zip,
			String phoneNo, String emailId)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}
	public void DisplayInfo(){
		System.out.println("firstName: " + firstName);
		System.out.println("lastName: " + lastName);
		System.out.println("city: " + address);
		System.out.println("state: " + state);
		System.out.println("zip: " + zip);
		System.out.println("phoneNumber: " + phoneNo);
		System.out.println("email: " + emailId);
	}
	public static void main(String[] args) {
		AddressBookMain contact = new AddressBookMain( "Manasi", "Singh", "jhjkchksj",
				"gdjhkhgvgjas","73482", "19827556378", "manasi@gmail.com");
		contact.DisplayInfo();
		System.out.println(contact);
	}
}
