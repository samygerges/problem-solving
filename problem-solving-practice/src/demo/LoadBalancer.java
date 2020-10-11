package demo;

public interface LoadBalancer
{
	void register(Provider provide);

	int getNumberOfRegisteredProviders();

	int getMaxNumberOfProviders();

	boolean isUnique(Provider provider);
}
