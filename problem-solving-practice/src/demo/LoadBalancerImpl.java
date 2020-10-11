package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implement load balancer which can register providers, it has to have up to max 10 providers and each provider has a unique address
 */
public class LoadBalancerImpl implements LoadBalancer
{
	private static final int MAX_PROVIDERS = 10;
	private final List<Provider> providers;

	public LoadBalancerImpl()
	{
		providers = new ArrayList<>();
	}

	@Override
	public void register(Provider provider)
	{
		if (provider == null)
		{
			throw new IllegalArgumentException("Provider can not be null");
		}
		if (getMaxNumberOfProviders() == getNumberOfRegisteredProviders())
		{
			throw new IllegalStateException("Can not add more providers");
		}
		if (!isUnique(provider))
		{
			throw new IllegalArgumentException("Provider address is not unique");
		}

		providers.add(provider);
	}

	@Override
	public int getNumberOfRegisteredProviders()
	{
		return providers.size();
	}

	@Override
	public int getMaxNumberOfProviders()
	{
		return MAX_PROVIDERS;
	}

	@Override
	public boolean isUnique(Provider provider)
	{
		if (provider == null)
		{
			throw new IllegalArgumentException("Provider can not be null");
		}

		List<Provider> sameAddress = providers.stream().filter(prov -> prov.getAddress().equals(provider.getAddress())).collect(Collectors.toList());
		return sameAddress.isEmpty();
	}
}
