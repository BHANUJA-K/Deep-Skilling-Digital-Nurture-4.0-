public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shirt", "Fashion"),
            new Product(3, "Phone", "Electronics"),
            new Product(4, "Shoes", "Footwear"),
            new Product(5, "Watch", "Accessories")
        };
        System.out.println("\n Binary Search:");
        BinarySearch.sortProductsByName(products);  // Sort before binary search
        Product result2 = BinarySearch.binarySearch(products, "Phone");
        System.out.println(result2 != null ? "Found: " + result2 : "Product not found");
    }
}
