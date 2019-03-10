package escholz.greenfield.net.catalog.models

/**
 * This type contains the output payload of the getChangeRequests call, which is a portion of the collection of change
 * requests that match the search criteria. The returned set of change requests is a page, and the response includes
 * information for navigating the output pages.
 */
data class GetChangeRequestsResponse(
    /**
     * Contains the full details of one or more catalog change requests, including the original payload of the
     * createChangeRequest call, processing status and key dates, and resolution details.
     */
    val changeRequests: List<ChangeRequest>,

    /**
     * The URI of the getChangeRequests call request that produced this page of results.
     */
    val href: String,

    /**
     * The maximum number of change requests in this page, a subset of the full collection of change requests that
     * match the filter criteria of this call. This field combines with the offset field to identify the change requests
     * being returned.
     */
    val limit: Int,

    /**
     * The getChangeRequests call URI for the next page. For example, the following URI returns records 41 thru 50 from
     * the collection of change requests: path/change_request?limit=10&amp;offset=40 Note: This feature employs a
     * zero-based list, where the first order in the list has an offset of 0.
     */
    val next: String,

    /**
     * The first change request in this page based on its position in the returned collection of change requests.
     * For example, if offset is set to 10 and limit is set to 10, this page includes change requests 11 thru 20 from
     * the resulting collection of change requests. Note: This feature employs a zero-based list, where the first item
     * in the list has an offset of 0.
     */
    val offset: Int,

    /**
     * The getChangeRequests call URI for the previous page. For example, the following URI returns orders 21 thru 30
     * from the collection of orders: path/change_request?limit=10&amp;offset=20 Note: This feature employs a
     * zero-based list, where the first order in the list has an offset of 0.
     */
    val prev: String,

    /**
     * The total number of change requests in the collection. Note: If no change requests are found, this field is
     * returned with a value of 0.
     */
    val total: Int
)