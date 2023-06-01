# Android Draw
A drawing view for your android application  
<img src="https://github.com/nguyenDungTien/Simple_Draw/blob/master/cover.png" width="320">  
## 1. Use Activity
```kotlin
class MainActivity : AppCompatActivity() {
    //tạo đối tượng đồng hành để khia báo biến toàn cục cho phép biến được  sử dụng taonf bộ trong các class trong ứng dụng
    companion object{
        var path = Path()
        var paintBrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ẩn actionsbar
        supportActionBar?.hide()
        redColor.setOnClickListener {
            paintBrush.color=Color.RED
            currentColor(paintBrush.color)

        }
        blackColor.setOnClickListener {
            paintBrush.color=Color.BLACK
            currentColor(paintBrush.color)

        }
        blueColer.setOnClickListener {
            paintBrush.color=Color.BLUE
            currentColor(paintBrush.color)

        }
        whiteColor.setOnClickListener {
            pathList.clear()
            colorList.clear()
            path.reset()
        }
    }
    private fun currentColor(color:Int){
        currentBrush=color
        path = Path()
    }
}
```
## 2.Use DrawView
- Companion object
```kotlin
companion object{
        //tạo biến lưu danh sách đường được vẽ
        var pathList = ArrayList<Path>()
        //tạo biến lưu danh sách các màu
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK
    }
```
- init function
```kotlin
private  fun init(){
        paintBrush.isAntiAlias = true
        paintBrush.color= currentBrush
        paintBrush.style=Paint.Style.STROKE
        //nối các nét vẽ
        paintBrush.strokeJoin=Paint.Join.ROUND
        paintBrush.strokeWidth = 8f

        params=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }
```
- onTouchEvent function
```kotlin
 override fun onTouchEvent(event: MotionEvent): Boolean {
        var x =event.x
        var y = event.y

        when(event.action){
            MotionEvent.ACTION_DOWN->{
                path.moveTo(x,y)
                return true
            }
            MotionEvent.ACTION_MOVE->{
                path.lineTo(x,y)
                pathList.add(path)
                colorList.add(currentBrush)

            }
            else ->return false
        }
        postInvalidate()
        return false
    }
 ```
 - onDraw function
 ```kotlin
 override fun onDraw(canvas: Canvas?) {
        for (i in pathList.indices){
            paintBrush.setColor(colorList[i])
            canvas?.drawPath(pathList[i], paintBrush)
            invalidate()


        }
    }
 ```
