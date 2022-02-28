// https://leetcode.com/problems/reformat-date

class Solution {
    Map<String, String> month;
    public String reformatDate(String date) {
        month = buildMonth();
        
        String[] dateAsString = date.split(" ");
        String day = dateAsString[0];
        String dayAsInt = "0";
        if (Character.isDigit(day.charAt(1))) {
            dayAsInt = day.substring(0, 2);
        } else {
            dayAsInt = dayAsInt + Integer.parseInt(day.charAt(0) + "");
        }
        String monthAsInt = month.get(dateAsString[1]);
        String year = dateAsString[2];
        return String.format("%s-%s-%s", year, monthAsInt, dayAsInt);
    }
    
    private Map<String, String> buildMonth() {
        Map<String, String> month = new HashMap<>();
        month.put("Jan", "01");
        month.put("Feb", "02");
        month.put("Mar", "03");
        month.put("Apr", "04");
        month.put("May", "05");
        month.put("Jun", "06");
        month.put("Jul", "07");
        month.put("Aug", "08");
        month.put("Sep", "09");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");
        return month;
    }
}