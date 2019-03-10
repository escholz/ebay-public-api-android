package escholz.greenfield.net.catalog.models

/**
 * This type contains the full details of a suggested product, including information about the product's identifiers,
 * description, product images, categories, and aspects.
 */
data class SuggestedProduct(
    /**
     * A list of URLs for additional images associated with the suggested product. For the URL of the primary image,
     * see the imageUrl field.
     */
    val additionalImageUrls: List<String>,

    /**
     * Contains one or more category aspects and their values that are associated with the suggested product.
     */
    val aspects: List<ProductAspect>,

    /**
     * The manufacturer's brand name for the suggested product.
     */
    val brand: String,

    /**
     * A rich description of the suggested product, which can contain HTML, including the following basic tags:
     * <p />
     * Text formatting tags such as &lt;b&gt;, &lt;i&gt;, &lt;br&gt;, &lt;ol&gt;, &lt;ul&gt;, and &lt;li&gt;
     * <p />
     * Table formatting tags such as &lt;table&gt;, &lt;tr&gt;, &lt;td&gt;, &lt;th&gt;, &lt;thead&gt;, &lt;tfoot&gt;,
     * &lt;tbody&gt;, &lt;caption&gt;, &lt;col&gt;, and &lt;colgroup&gt;
     * <p />
     * Note: Active content from sellers is prohibited on eBay, including animation or video via JavaScript, Flash,
     * plug-ins, or form actions.
     */
    val description: String,

    /**
     * A list of all European Article Numbers (EANs) that identify the suggested product.
     */
    val ean: List<String>,

    /**
     * Required or returned only if the value of the changeRequestType field is PRODUCT_UPDATE. This is the eBay
     * product ID of the product record for which an update is being suggested.
     */
    val epid: String,

    /**
     * Required or returned if the value of the changeRequestType field is PRODUCT_CREATION. This is the URL of the
     * primary image associated with the suggested product.
     */
    val imageUrl: String,

    /**
     * A list of all International Standard Book Numbers (ISBNs) that identify the suggested product.
     */
    val isbn: List<String>,

    /**
     * A list of all Manufacturer Product Number (MPN) values that the manufacturer uses to identify the suggested
     * product.
     */
    val mpn: List<String>,

    /**
     * A list of category IDs (other than the value of primaryCategoryId) for all the leaf categories to which the
     * suggested product might belong.
     */
    val otherApplicableCategoryIds: List<String>,

    /**
     * The identifier of the category that eBay recommends using to list the suggested product, based on previous
     * listings of similar products. Products in the eBay catalog are not automatically associated with any particular
     * category, but using an inappropriate category can make it difficult for prospective buyers to find the product.
     * For other possible categories that might be used, see otherApplicableCategoryIds.
     */
    val primaryCategoryId: String,

    /**
     * The catalog title that will be used as the listing title for all item listings based on the suggested product.
     */
    val title: String,

    /**
     * A list of all Universal Product Codes (UPCs) that identify the suggested product.
     */
    val upc: List<String>,

    /**
     * Required or returned only if the value of changeRequestType is PRODUCT_UPDATE. This is the current version
     * number in the catalog of the product record for which an update is being suggested.
     */
    val version: String
)