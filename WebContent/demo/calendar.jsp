<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dynamic Calendar</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .header {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        .time-slot {
            background-color: #e0e0e0;
        }
        .selected {
            background-color: #ffcccc;
        }
        .booking-info {
            display: none;
            margin-top: 20px;
        }
        .booking-info table {
            width: auto;
            border: 1px solid #ddd;
        }
        .booking-info td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        .booking-info th {
            background-color: #f2f2f2;
        }
    </style>
    <script>
        function showTimes(date) {
            var bookingInfo = document.getElementById('booking-info');
            var dateStr = date.toISOString().split('T')[0];
            var bookingTable = document.getElementById('booking-table');
            
            // Clear previous data
            bookingTable.innerHTML = '';
            
            // Add time slots
            var timeSlots = ['9 AM - 10 AM', '10 AM - 11 AM', '11 AM - 12 PM', '1 PM - 2 PM', '2 PM - 3 PM', '3 PM - 4 PM'];
            for (var i = 0; i < timeSlots.length; i++) {
                var row = document.createElement('tr');
                var timeCell = document.createElement('td');
                timeCell.innerHTML = timeSlots[i];
                row.appendChild(timeCell);

                var slotCell = document.createElement('td');
                slotCell.innerHTML = '<button onclick="selectSlot(this, \'' + timeSlots[i] + '\')">Select</button>';
                row.appendChild(slotCell);
                
                bookingTable.appendChild(row);
            }

            // Display booking info section
            bookingInfo.style.display = 'block';
            document.getElementById('selected-date').innerHTML = dateStr;
        }

        function selectSlot(button, timeSlot) {
            // Remove previous selections
            var buttons = document.querySelectorAll('#booking-table button');
            buttons.forEach(btn => btn.parentElement.classList.remove('selected'));
            
            // Mark the selected slot
            button.parentElement.classList.add('selected');
        }
    </script>
</head>
<body>
    <h2>Dynamic Calendar</h2>
    <table>
        <thead>
            <tr class="header">
                <th>Time Slot</th>
                <th>Monday</th>
                <th>Tuesday</th>
                <th>Wednesday</th>
                <th>Thursday</th>
                <th>Friday</th>
            </tr>
        </thead>
        <tbody>
            <% 
                // Define time slots
                String[] timeSlots = {
                    "9 AM - 10 AM",
                    "10 AM - 11 AM",
                    "11 AM - 12 PM",
                    "1 PM - 2 PM",
                    "2 PM - 3 PM",
                    "3 PM - 4 PM"
                };

                // Generate current month's calendar
                java.util.Calendar cal = java.util.Calendar.getInstance();
                int month = cal.get(java.util.Calendar.MONTH);
                int year = cal.get(java.util.Calendar.YEAR);
                
                cal.set(year, month, 1);
                int firstDayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
                int numDaysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

                // Loop through each time slot
                for (String timeSlot : timeSlots) { 
            %>
                <tr>
                    <td class="time-slot"><%= timeSlot %></td>
                    <% for (int j = 1; j <= 5; j++) { %>
                        <td><button onclick="showTimes(new Date(<%= year %>, <%= month %>, <%= j %>))">Select</button></td>
                    <% } %>
                </tr>
            <% 
                } 
            %>
        </tbody>
    </table>

    <!-- Booking Information Section -->
    <div id="booking-info" class="booking-info">
        <h3>Available Slots for <span id="selected-date"></span></h3>
        <table id="booking-table">
            <!-- Time slots will be dynamically added here -->
        </table>
    </div>
</body>
</html>
