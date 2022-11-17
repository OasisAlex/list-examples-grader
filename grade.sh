# Create your grading script here
set -e
rm -rf student-submission
git clone $1 student-submission

echo "successfully copy"
cd student-submission

if [[ -e ListExamples.java ]]
then
    echo "The file exist"
else
    echo "The file not found"
    echo "Maybe Wrong File Name"
    exit 1
fi


cd ../
cp -rf lib student-submission
cp -f TestListExamples.java student-submission

cd student-submission

ls 
if [[ -e TestListExamples.java ]]
then
   echo "The Testlistexamples file is been copy"
else
   echo "The Testlistexamples file is not been copy"
   exit 1
fi

cpath=".:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar"

set +e
javac -cp $cpath *.java


if [[ $? -eq 0 ]]
then
  echo "compiled"
else
  echo "didn't compiled"
  exit 1
fi

java -cp $cpath org.junit.runner.JUnitCore TestListExamples > out.txt

if [[ $? -eq 0 ]]
then
  grep "OK" out.txt
  exit 0
else
  grep "Tests run:" out.txt
  exit 1
fi





