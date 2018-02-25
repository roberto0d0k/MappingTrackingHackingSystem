function T = indivIDinfo(C,nameC, A, areaD)
prompt = 'Enter individual tracking number: '; %prompts user for ID number
trackIDnum = input(prompt); %takes in user input, need to type as 'word'
C(C~=trackIDnum)=0; %replaces all elements not equal to IDnumber with '0'
ind=find(C); %finds indices of non-zero elements
T=table(nameC(ind),A(ind),areaD(ind)); %creates a table for display
T.Properties.VariableNames= {'Name' 'time' 'Location'};  %table headers
disp(T);
