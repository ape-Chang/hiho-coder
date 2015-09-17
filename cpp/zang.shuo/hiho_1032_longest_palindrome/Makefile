CXXFLAGS =	-g -Wall -fmessage-length=0

OBJS =		longest_palindrome_manacher.o

LIBS =

TARGET =	longest_palindrome_manacher.exe

$(TARGET):	$(OBJS)
	$(CXX) -o $(TARGET) $(OBJS) $(LIBS)

run:	$(TARGET)
	./$(TARGET)

all:	$(TARGET)

clean:
	rm -f $(OBJS) $(TARGET)
