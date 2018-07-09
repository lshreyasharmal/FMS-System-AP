# FMS-Project

The purpose of this project is to create a desktop application to manage a system similar
to FMS in IIIT Delhi.  
Departments in the system:
  1. Electricity
  2. Heating, Ventilation, Air-Conditioning(HVAC)
  3. Audio/Video
  4. Security
  5. Housekeeping  
  
Users in the system:  
  ● GM or Admin  
  ● Electricity supervisor and staff  
  ● HVAC supervisor and staff  
  ● Audio/video supervisor and staff  
  ● Security supervisor and security staff  
  ● Housekeeping supervisor and staff    
Functional Requirements:    
  ● GM, supervisors and staff can login and logout of the system.  
  ● Every user gets a unique ID and username when added to the system.  
  ● There can be only one admin of the system and one supervisor from each
  department.  
  ● Registration of the new staffer should be approved by the admin or supervisor.     
  ● GM or Admin:   
    ● Can add/view/delete supervisors and staff.  
    ● Can assign task to supervisors.  
    ● Can approve/reject or keep the logistics requests by supervisors on hold.  
    ● Whatever is visible to supervisors and staff in the system should also be
    visible to the admin.  
  ● Department Supervisors:    
    ● Can add/view/delete his/her department staff.  
    ● Supervisors can assign tasks to an individual staff member or to some staff
    members or to all staff members at once.  
    ● Department supervisors maintain logistics of their respective departments,
    approve requirement requests by staff.  
    ● Supervisors can send logistics approval requests for inventory to GM.  
    ● Send leave to GM.  
    ● View task reports.  
  ● Staff:  
    ● Send logistics requirement for task to department supervisor.  
    ● Send leave to department supervisor.  
    ● Update status of the task to ONGOING or COMPLETE.  
    ● Generate task report (Can be saved in pdf or text format).  
    ● When a staffer is being assigned a task, his/her status (Busy (till when), Available,
    on Leave (till when)) should be visible to department supervisors/admin.  
Tasks:  
  ● Tasks may or may not have a completion deadline.  
  ● Staffer reports back on his/her assigned task with one of the three statuses:  
  1. NOT STARTED (default)
  2. ONGOING
  3. COMPLETE
  ● If status is COMPLETE then staffer should have the option to generate a task
  completion report.  
  ● Task assignments and reportings must all be accompanied with a system
  generated timestamp.  
