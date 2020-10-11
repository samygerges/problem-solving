package demo;

public class Server implements Provider
{
	private String address;

	public Server(String address)
	{
		this.address = address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Override
	public String getAddress()
	{
		return address;
	}
}
