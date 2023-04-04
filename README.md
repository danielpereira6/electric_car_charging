# Electric Car Charging
Project made for University work nº1 of the subject "Integration Technologies".

With the aim of implementing a monthly payment system for customers. 
The amount corresponding to the charging of the vehicle will be charged in a single payment at the end of the month. 
In order to monitor consumption, a file is sent in XML format with information of the electrical charge made.

The application must have:
- Validation of XML files based on an XML Schema document
- Calculation of the amount to be paid in the month, based on the loaded XML files
- Writing of the XML file with simulated loading data

### How it works:
- For the project, only one client was considered.
- Inside the `"\src\main\resources\"` folder I include a `Client` folder that later can be a list of folders per client.
- The client has several folders with the months of the year. Within each month you should have the XML file with the shipments, this should have the name "carregamento_**X**.xml", where **X** corresponds to the shipment number. e.g: *carregamento_1.xml*, *carregamento_2.xml*, etc.