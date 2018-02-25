%% Check traffic or usage in location of interest
function T = indivNameInfo(C,nameC, A, areaD)
prompt = 'Enter individual name: '; %prompts user
trackName = input(prompt); %takes in user input
NameNum=0;
switch trackName %associates input with the respective ID number
    case 'Nurse Roberto'
        NameNum=1;
    case 'Dr Gopika'
        NameNum=2;
    case 'Ethan'
        NameNum=3;
    case 'Ben'
        NameNum=4;
    case 'John Doe'
        NameNum=5;
    otherwise
        disp('not a valid location');
end
C(C~=NameNum)=0; %replaces all elements not equal to Name IDnumber with '0'
ind=find(C); %finds indices of non-zero elements
T=table(nameC(ind),A(ind),areaD(ind)); %creates a table for display
T.Properties.VariableNames= {'Name' 'time' 'Location'}; %table headers
disp(T);
