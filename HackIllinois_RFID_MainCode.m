%% Convert spreadsheet data into arrays that can be correlated
%convert the .xlsx spread sheet to a table to accomodate for non-numerical data
%every name/ location/ activity is associated with a unique ID#
%nameID is from RF ID's
%
%
% ignore a warning about modified variable names
%____________________________________________________________________%
data=readtable('matlab_exceltest.xlsx'); %read spreadsheet as a table 
time=data(1:end, 1); %get time information from all rows, column 1
    A=table2array(time);
nameID=data(1:end, 2); %get ID number information from all rows, column 2
    C=table2array(nameID);
name=data(1:end, 3); %get username information from all rows, column 3
    nameC=table2cell(name);
areaID=data(1:end, 4); %get location number information from all rows, column 4
    D=table2array(areaID);
area=data(1:end, 5); %get location information from all rows, column 5
    areaD=table2cell(area);
activityID=data(1:end, 6); %get activity number information from all rows, column 6
    E=table2array(activityID);
activity=data(1:end, 7); %get activity information from all rows, column 1
    activityE=table2cell(activity);

%% Exmaple functions
%can prompt any of these in loops for multiple user analysis
%can use app designer or GUI for ease of use for user
%
%
%Other potential functions - track activities in a certain time period
%Check for inefficiences, how long time is spent on important activities
%incorporate feedback based on data
%plot correlations and generate reports
%
%
%basically as a security camera without actually "spying" on people
%
%the functions prompt user for ID, location, etc. of interest and displays data of interest

T=indivIDinfo(C,nameC, A, areaD); %location and time of user based on ID 
X=locationTraffic(D); %traffic in a certain location
Y=indivNameInfo(C,nameC, A, areaD); %location and time of user based on name




