package escholz.greenfield.net.catalog.models

/**
 * This type contains the input payload of the createChangeRequest call, including the type of request, the reason for
 * a product update request, and the details of the new or updated product being suggested.
 */
data class CreateChangeRequestPayload(
    /**
     * The type of catalog modification being requested by this change request.
     * <p />
     * Available values:
     * <p />
     * PRODUCT_CREATION &mdash; Change request to create a new product
     * PRODUCT_UPDATE &mdash; Change request to update an existing product
     *
     * @see <a href='https://developer.ebay.com/devzone/rest/api-ref/catalog/types/ChangeRequestType.html'>eBay API documentation</a>
     */
    val changeRequestType: String,

    /**
     * Required if the value of changeRequestType is PRODUCT_UPDATE, and optional otherwise; this is a text description
     * of why this change is being requested.
     */
    val reasonForChangeRequest: String,

    /**
     * Required if the referenceType field is included in the request. This is the identifier of an object of the type
     * specified by the value of referenceType. For example, if the value of referenceType is INVENTORY_ITEM, this
     * field should contain the seller's SKU for an inventory item.
     */
    val referenceId: String,

    /**
     * The type of object that the requested change is intended to support. This applies to objects that are incomplete
     * due to the need for a matching catalog product. Providing a referenceType and a referenceId in a catalog change
     * request enables eBay to automatically apply the resulting new or updated product directly to the specified object
     * without requiring additional action on your part.
     * <p />
     * Available values:
     * <p />
     * INVENTORY_ITEM &mdash; The requested change will support the completion of an inventory item, which you can then
     * use to create an offer.
     * <p />
     * LISTING &mdash; The requested change will support the modification of an active product listing.
     * <p />
     * LISTING_DRAFT &mdash; The requested change will support the completion of an offer, which you can then publish as
     * a product listing.
     *
     * @see <a href='https://developer.ebay.com/devzone/rest/api-ref/catalog/types/ReferenceType.html'>eBay API documentation</a>
     */
    val referenceType: String,

    /**
     * Contains the full details of the suggested product, including information about the product's identifiers,
     * description, product images, categories, and aspects.
     */
    val suggestedProduct: SuggestedProduct
)