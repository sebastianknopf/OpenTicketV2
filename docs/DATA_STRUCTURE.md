# Data Structure

The OpenTicket library provides several standard fields for common information in public transport tickets. 

A message of type Envelope is the main container for each OpenTicket message. It defines the version used in
the present OpenTicket message, the key which is used for encryption as well as at least one encrypted legitimation
as byte array. The whole structure looks like this:

**Envelope**

|Field|Type|Description|
|---|---|---|
|envelopeVersion|uint32|Envelope version which is used (Statically 2)|
|keyName|String|Name of the key which is used for encryption|
|encryptedLegitimations|ByteString[]|Byte arrays of encrypted legitimation data|

A legitimation message encapsulates all required information analogous to a conventional ticket as follows:

**Legitimation**

|Field|Type|Description|
|---|---|---|
|legitimationId|uint32|The ambiguous legitimation ID|
|dateTimeOfOrder|uint32|Unix timestamp of order|
|validFrom|uint32|Unix timestamp of validity begin|
|validUntil|uint32|Unix timestamp of validity end|
|optionFlags|uint32|Container for custom flags|
|product|ProductRecord|Container for product information|
|passenger|PassengerRecord|Container for passenger information|
|relation|Relation|The relation the legitimation is valid for &ast;&ast;|
|areaList|AreaList|All tariff areas the legitimation is valid for &ast;&ast;|
|stopList|StopList|All stops which can be reached with this legitimation &ast;&ast;|
|price|uint32|Complete price as integer &ast;|
|tax|uint32|Amount of tax as integer &ast;|

&ast; multiply with 10 or more regarding to your currency

&ast;&ast; note that you can only set one of these three types! Setting one type will delete any other one

Within the ProductRecord message you'll find all product related information:

**ProductRecord**

|Field|Type|Description|
|---|---|---|
|name|String|Shortened product name|
|infoText|String|Short information text|
|serviceClass|uint32|Service class of the product|

The PassengerRecord message contains all information about traveling passengers:

**PassengerRecord**

|Field|Type|Description|
|---|---|---|
|personRelated|boolean|Whether the legitimation is related to one person or not|
|name|String|Name of the passenger for identification|
|age|uint32|Age of the passenger for identification|
|gender|Gender(Enum)|DIVERS/MALE/FEMALE|
|numAdults|uint32|Number of adults the legitimation is valid for|
|numChildren|uint32|Number of children the legitimation is valid for|

For modelling the spatial validity there're three types of messages: Relation, AreaList
and StopList. A Relation message is used for legitimations which is bound to a certain relation.
Relation-less legitimations can be modeled using the AreaList type. For legitimations which are based
on the number of stops (for e.g. short-way tickets) you should use the type StopList.

**Relation**

|Field|Type|Description|
|---|---|---|
|startStopId|uint32|Stop ID of the source stop|
|destStopId|uint32|Stop ID of the destination stop|
|containingAreaIds|uint32[]|At least one fare area ID where the legitimation is valid in|

**AreaList**

|Field|Type|Description|
|---|---|---|
|startStopId|uint32|Optional stop ID of the source stop|
|containingAreaIds|uint32[]|One or more fare area IDs where the legitimation is valid in|

**StopList**

|Field|Type|Description|
|---|---|---|
|startStopId|uint32|Stop ID of the source stop|
|containingStopIds|uint32[]|All stop IDs which can be reached with this legitimation|

[< Security](SECURITY.md) | [Code Usage >](CODE_USAGE.md)