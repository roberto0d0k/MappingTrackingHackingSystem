%% Check traffic or usage in location of interest
function x = locationTraffic(D)
prompt = 'Enter location to check traffic: '; %prompts user
trackLoc = input(prompt); %takes in user input, need to type as 'word'
LocNum=0;
switch trackLoc %associates input with the respective location ID number
    case 'hallway'
        LocNum=1;
    case 'patient room 1'
        LocNum=2;
    case 'lounge'
        LocNum=3;
    case 'patient room 2'
        LocNum=4;
    case 'ICU'
        LocNum=5;
    case 'OR'
        LocNum=6;
    otherwise
        disp('not a valid location');
end
D(D~=LocNum)=0; %replaces all elements not equal to location number with '0'
ind=find(D); %finds indices of non-zero elements
x=numel(ind); %finds the number of such elements (A.K.A number of people that used the space)
disp(x); %displays traffic