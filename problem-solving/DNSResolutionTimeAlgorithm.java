import java.util.*;

/*
 A Domain Name System (DNS) translates domain names to IP addresses which are then used by browsers to load internet resources.
 For quicker DNS lookups, browsers often store a number of recent DNS queries in a DNS cache.
 Retrieving data from the cache is often faster than retrieving it from a DNS server.
 This task aims to simulate DNS resolution and determine the time taken to process different URLs.

 Assume that the DNS cache can store a maximum of the cache_size most recent DNS requests, i.e., URL-IP mappings.
 The cache is initially empty.
 It takes cache_time units of time to fetch data from the DNS cache, and server_time units of time to fetch data from the DNS server.
.
Given a list of n URLs visited as an array of strings, urls, determine the minimum time taken to resolve each DNS request.
Note: New DNS requests are dynamically added to the cache, and the cache stores mappings according to the order in which the requests were made

Example
Suppose cache size = 3, cache_time = 2, server_time = 5, urls = ["http://www.hackerrank.com", "http://www.google.com",
 "http://www.yahoo.com", "http://www.gmail.com", "http://www.yahoo.com", "http://www.hackerrank.com", "http://www.gmail.com"]

Output
[5,5,5,5,5,2] is the minimum time to resolve each DNS request
 */

public class DNSResolutionTimeAlgorithm {

    public static List<Integer> minDnsResolutionTime(List<String> urls, int cacheSize, int cacheTime, int serverTime) {
        Map<String, Integer> dnsCache = new HashMap<>();
        List<Integer> resolutionTimes = new ArrayList<>();

        for (String url : urls) {
            if (dnsCache.containsKey(url)) {
                resolutionTimes.add(cacheTime);
                // Update the timestamp of the accessed URL in the cache
                dnsCache.put(url, resolutionTimes.size() - 1);
            } else {
                resolutionTimes.add(serverTime);
                // Simulate fetching data from the DNS server
                dnsCache.put(url, resolutionTimes.size() - 1);

                // Ensure the cache does not exceed the specified size
                if (dnsCache.size() > cacheSize) {
                    // Find and remove the oldest entry from the cache
                    String oldestUrl = dnsCache.entrySet()
                            .stream()
                            .min(Comparator.comparing(Map.Entry::getValue))
                            .map(Map.Entry::getKey)
                            .orElse(null);

                    dnsCache.remove(oldestUrl);
                }
            }
        }

        return resolutionTimes;
    }

    public static void main(String[] args) {
        // Example usage with List<String>
        List<String> urls = List.of(
                "http://www.hackerrank.com", "http://www.google.com", "http://www.yahoo.com",
                "http://www.gmail.com", "http://www.yahoo.com", "http://www.hackerrank.com",
                "http://www.gmail.com");
        int cacheSize = 3;
        int cacheTime = 2;
        int serverTime = 5;

        List<Integer> result = minDnsResolutionTime(urls, cacheSize, cacheTime, serverTime);
        System.out.println("Minimum time to resolve each DNS request: " + result);
    }
}

