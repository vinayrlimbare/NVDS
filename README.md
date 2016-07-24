# NVDS

run the mainJFrame.java file from NVDS-Vinay Limbare\src\UserInterface

#About the project 

National Vaccine Distribution System

Problem
Vaccine Distribution Management is hardly used in distribution of vaccines. Currently, vaccine management generally consists of a mess of isolated computer applications and paper-based systems. Improper distribution of vaccines results in vaccines being used inefficiently and expired vaccine products, inventory control issues, and high costs also has the effect on the safety. The demand and supply of vaccines are touch to find. Also there needs to be check on the vaccines being wasted (Package which got wasted and reason for it) so that in future the same can be avoided. Therefore, an effective vaccine supply chain management is essential to ensure product quality and efficient usage of it. National Vaccine Distribution System is a vaccine inventory management and distribution system that will operate at the national, state and local levels which can improve the efficiency, accountability, and the ability to respond to safety problems and public health crisis.

Goal
The scope of the project includes vaccine financial management, vaccine distribution, provider ordering (hospital and clinics), inventory management, and the operation of the national vaccine stockpile.
•	The project will include Configuration management that defines users, geographies, enterprises and including hospitals and their associated satellite clinics.
•	It will include Inventory Management and as it related to pharmaceutical companies.
•	It includes Distribution centres that manage the flow of vaccines from inventory centres to providers. 
•	It includes Provider contract management where providers agree to certain delivery schedule. Providers must have a Provider Agreement for Receipt of Supplied Vaccines.
•	Providers request vaccines for their hospital and clinic operations. 
•	It has Clinics that supplied by parent hospitals. 
•	The project Addresses how the flow of funds and payments go through the system. 
•	It also addresses Vaccine adverse event management

Deliverables
The application developed at the end of this project is used to maintain the vaccines. Currently the CDC doesn’t have all the information of the supply and the demands. Hence we need to make this CDC nationalized so that it can track or monitor the supply of vaccination and also control the flow using supply chain. This nationalized CDC can help in monitoring the goods in efficient way. 
The organization structure will consist of many entities. An organization will control and perform the functionalities that have been given to it. The organization consists of many roles. Each role will have many work responsibilities and perform a specific task. These tasks are monitored so that the tasks are in sync with the CDC.

Assumptions
•	CDC will have enough initial funds to start the process of nationalization and cover for insurance claims (if it happens). 
•	CDC will either approve or reject the request for manufacturers. 
•	Acts of God and unforeseen accidents to the supply chain is not considered as an important factor.
•	Population of every state is known approximately 
•	The formula to allot maximum vaccine for every state is as per the project convenience.
•	Vaccine for every disease is known.

Roles
Center for Disease Control (CDC):  Receive vaccine order from individual state Public Health Department (PHD) for vaccine. Orders are approved by CDC according to state allocation and passed on to national distributor for shipping directly to hospitals, pharmacies, clinics, etc (referred to as sites).The CSC keeps track of available inventory on a daily basis and uses a formula to determine how to allocate vaccines supply to sites. The formula is based on the population size of each state. A site can only order from the allocated quantity for that state. If the limit is reached for that state then the order is delayed or rejected. 
Distributer: Single National wide distributor who supplies to the registered hospitals and clinics. 
Department of Public Health: Every sites request for vaccines to the PHD. PHD checks if the sites are registered and forwards to CDC when approve. This is later prepared for shipping. 
Provider: The submit request for vaccines to the CDC.
Sites: Clinic, Hospitals and Satellite clinic are called sites.


