
package com.aiviralbooster.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Bg = Color(0xFF070B10)
private val Panel = Color(0xFF111B24)
private val Neon = Color(0xFF00F5A0)
private val Cyan = Color(0xFF00D9FF)
private val Muted = Color(0xFF91A5B4)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoosterApp()
        }
    }
}

@Composable
fun BoosterApp() {
    var selectedTab by remember { mutableStateOf(0) }

    MaterialTheme(
        colorScheme = darkColorScheme(
            background = Bg,
            surface = Panel,
            primary = Neon,
            secondary = Cyan
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Bg
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp)
            ) {
                Header()

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("Tổng quan", "Quét bài", "Tăng trưởng", "Quảng cáo", "Báo cáo")
                        .forEachIndexed { index, title ->
                            Button(
                                onClick = { selectedTab = index },
                                modifier = Modifier.weight(1f),
                                contentPadding = PaddingValues(4.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (selectedTab == index)
                                        Neon else Panel,
                                    contentColor = if (selectedTab == index)
                                        Color.Black else Color.White
                                ),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(
                                    title,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                }

                Spacer(modifier = Modifier.height(18.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                ) {
                    when (selectedTab) {
                        0 -> Dashboard()
                        1 -> ScanScreen()
                        2 -> GrowthScreen()
                        3 -> AdsScreen()
                        4 -> ReportScreen()
                    }
                }

                Text(
                    "AI VIRAL BOOSTER • HACKER EDITION",
                    color = Neon,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun Header() {
    Column {
        Text(
            "AI VIRAL BOOSTER",
            color = Neon,
            fontSize = 25.sp,
            fontWeight = FontWeight.Black
        )
        Text(
            "HACKER EDITION  //  TRỢ LÝ TĂNG TRƯỞNG AI",
            color = Cyan,
            fontSize = 10.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "● HỆ THỐNG DEMO ĐANG HOẠT ĐỘNG",
            color = Neon,
            fontSize = 11.sp
        )
    }
}

@Composable
fun SectionTitle(title: String, subtitle: String = "") {
    Text(
        title,
        color = Neon,
        fontSize = 19.sp,
        fontWeight = FontWeight.Bold
    )
    if (subtitle.isNotEmpty()) {
        Text(subtitle, color = Muted, fontSize = 12.sp)
    }
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun InfoCard(title: String, value: String, description: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Panel),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, color = Muted, fontSize = 12.sp)
            Text(
                value,
                color = Neon,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold
            )
            Text(description, color = Muted, fontSize = 11.sp)
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun Dashboard() {
    SectionTitle(
        "BẢNG ĐIỀU KHIỂN",
        "Theo dõi và tối ưu nội dung Facebook & TikTok"
    )

    InfoCard("Nền tảng hỗ trợ", "2 nền tảng", "Facebook • TikTok")
    InfoCard("Trạng thái AI", "Sẵn sàng", "Bản demo giao diện")
    InfoCard("Chiến dịch quảng cáo", "Chưa kết nối", "Chưa có chiến dịch thực tế")

    Card(
        colors = CardDefaults.cardColors(containerColor = Panel)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("GỢI Ý TỪ TRỢ LÝ AI", color = Cyan, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "• Tạo nội dung có điểm nhấn ngay 3 giây đầu.\n" +
                "• Sử dụng hình ảnh và video chất lượng cao.\n" +
                "• Thử nghiệm nhiều tiêu đề và lời kêu gọi hành động.",
                color = Color.White,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun ScanScreen() {
    var url by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    SectionTitle("QUÉT & PHÂN TÍCH BÀI VIẾT", "Nhập đường dẫn hoặc nội dung bài đăng")

    OutlinedTextField(
        value = url,
        onValueChange = { url = it },
        label = { Text("Link bài viết Facebook / TikTok") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(10.dp))

    OutlinedTextField(
        value = content,
        onValueChange = { content = it },
        label = { Text("Hoặc dán nội dung bài viết") },
        modifier = Modifier.fillMaxWidth(),
        minLines = 4
    )

    Spacer(modifier = Modifier.height(12.dp))

    Button(
        onClick = {
            result = if (url.isBlank() && content.isBlank()) {
                "Bro hãy nhập link hoặc nội dung trước nhé."
            } else {
                "Đã nhận dữ liệu trong bản demo. Khi kết nối AI, hệ thống sẽ phân tích nội dung, tiêu đề và hashtag."
            }
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("PHÂN TÍCH BÀI VIẾT")
    }

    if (result.isNotEmpty()) {
        Spacer(modifier = Modifier.height(12.dp))
        Text(result, color = Neon)
    }
}

@Composable
fun GrowthScreen() {
    SectionTitle("CHIẾN LƯỢC TĂNG TRƯỞNG", "Phát triển tự nhiên và bền vững")

    InfoCard("Nội dung", "Chất lượng", "Tập trung giá trị cho người xem")
    InfoCard("Lịch đăng", "Đều đặn", "Thử nghiệm khung giờ phù hợp")
    InfoCard("Tương tác", "Chân thực", "Trả lời bình luận và xây dựng cộng đồng")

    Text(
        "Không sử dụng bot, lượt xem ảo hoặc tương tác giả.",
        color = Cyan,
        fontSize = 12.sp
    )
}

@Composable
fun AdsScreen() {
    var platform by remember { mutableStateOf("TikTok") }
    var budget by remember { mutableStateOf("100000") }
    var approved by remember { mutableStateOf(false) }

    SectionTitle("QUẢN LÝ QUẢNG CÁO", "Thiết lập ngân sách và duyệt thủ công")

    Text("Chọn nền tảng", color = Color.White)
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        listOf("TikTok", "Facebook").forEach {
            FilterChip(
                selected = platform == it,
                onClick = {
                    platform = it
                    approved = false
                },
                label = { Text(it) }
            )
        }
    }

    Spacer(modifier = Modifier.height(14.dp))

    OutlinedTextField(
        value = budget,
        onValueChange = {
            budget = it.filter { char -> char.isDigit() }
            approved = false
        },
        label = { Text("Ngân sách mỗi ngày (VNĐ)") },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(12.dp))

    Button(
        onClick = { approved = true },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("DUYỆT THIẾT LẬP DEMO")
    }

    if (approved) {
        Text(
            "Đã ghi nhận lựa chọn demo: $platform • $budget VNĐ/ngày. Chưa phát sinh chi phí.",
            color = Neon,
            modifier = Modifier.padding(top = 12.dp)
        )
    }

    Text(
        "Lưu ý: Đây chưa phải kết nối quảng cáo thật. Mọi chiến dịch thực tế cần kết nối API chính thức và xác nhận riêng.",
        color = Muted,
        fontSize = 12.sp,
        modifier = Modifier.padding(top = 16.dp)
    )
}

@Composable
fun ReportScreen() {
    SectionTitle("BÁO CÁO HIỆU QUẢ", "Theo dõi hiệu quả nội dung")

    InfoCard("Dữ liệu bài đăng", "Chưa có", "Chưa kết nối tài khoản")
    InfoCard("Lượt tiếp cận", "--", "Chờ dữ liệu từ nền tảng")
    InfoCard("Hiệu quả quảng cáo", "--", "Chưa có chiến dịch thực tế")
}

