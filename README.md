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
  1. GM or Admin  
  2. Electricity supervisor and staff  
  3. HVAC supervisor and staff  
  4. Audio/video supervisor and staff  
  5. Security supervisor and security staff  
  6. Housekeeping supervisor and staff  
  
Functional Requirements:      
  1. GM, supervisors and staff can login and logout of the system.  
  2. Every user gets a unique ID and username when added to the system.  
  3. There can be only one admin of the system and one supervisor from each
  department.  
  4. Registration of the new staffer should be approved by the admin or supervisor.     
  5. GM or Admin:   
    a. Can add/view/delete supervisors and staff.  
    b. Can assign task to supervisors.  
    c. Can approve/reject or keep the logistics requests by supervisors on hold.  
    d. Whatever is visible to supervisors and staff in the system should also be
    visible to the admin.  
  6. Department Supervisors:    
    a. Can add/view/delete his/her department staff.  
    b. Supervisors can assign tasks to an individual staff member or to some staff
    members or to all staff members at once.  
    c. Department supervisors maintain logistics of their respective departments,
    approve requirement requests by staff.  
    d. Supervisors can send logistics approval requests for inventory to GM.  
    e. Send leave to GM.  
    f. View task reports.  
  7. Staff:  
    a. Send logistics requirement for task to department supervisor.  
    b. Send leave to department supervisor.  
    c. Update status of the task to ONGOING or COMPLETE.  
    d. Generate task report (Can be saved in pdf or text format).  
  8. When a staffer is being assigned a task, his/her status (Busy (till when), Available,
    on Leave (till when)) should be visible to department supervisors/admin.  
  9.Tasks:  
    a. Tasks may or may not have a completion deadline.  
    b. Staffer reports back on his/her assigned task with one of the three statuses:  
     1. NOT STARTED (default)
     2. ONGOING
     3. COMPLETE  
     
  c. If status is COMPLETE then staffer should have the option to generate a task
  completion report.  
  d. Task assignments and reportings must all be accompanied with a system
  generated timestamp.  
