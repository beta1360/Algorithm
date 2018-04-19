class Rectangle{
private:
	int width;
	int height;
public:
	Rectangle(int width, int height){
		this->width = width;
		this->height = height;
	}

	const int get_width(){ return this->width; }
	const int get_height(){ return this->height; }
	void set_width(int width){
		if (width <= 0 || width > 1000) return;
		else this->width = width;
	}
	void set_height(int height){
		if (height <= 0 || height > 1000) return;
		else this->height = height;
	}
	const int area(){ return this->width*this->height; }
	const int perimeter(){return (2 * this->width + 2 * this->height); }
	const bool is_square(){
		if (this->width == this->height) return true;
		else return false;
	}
};
