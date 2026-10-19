
package com.example.trustnetvpn; // Replace with your actual package

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TermsOfServiceActivity extends AppCompatActivity {

    private final int backgroundColor = Color.rgb(11, 16, 32);
    private final int cardColor = Color.rgb(20, 29, 49);
    private final int accentColor = Color.rgb(100, 168, 255);
    private final int textColor = Color.rgb(220, 229, 244);
    private final int mutedColor = Color.rgb(169, 184, 207);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(backgroundColor);
        root.setPadding(dp(20), dp(12), dp(20), dp(20));

        TextView backButton = new TextView(this);
        backButton.setText("\u2190  Back");
        backButton.setTextColor(Color.WHITE);
        backButton.setTextSize(16);
        backButton.setGravity(Gravity.CENTER_VERTICAL);
        backButton.setPadding(dp(4), 0, 0, 0);
        backButton.setContentDescription("Go back");

        root.addView(backButton,
                new LinearLayout.LayoutParams(-1, dp(48)));

        backButton.setOnClickListener(v -> finish());

        TextView title = new TextView(this);
        title.setText("Terms of Service");
        title.setTextColor(accentColor);
        title.setTextSize(27);
        title.setTypeface(null, Typeface.BOLD);
        title.setPadding(0, dp(14), 0, dp(4));
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText(
                "TrustNet VPN \u2022 Last updated: October 19, 2026"
        );
        subtitle.setTextColor(mutedColor);
        subtitle.setTextSize(13);
        subtitle.setPadding(0, 0, 0, dp(18));
        root.addView(subtitle);

        ScrollView scrollView = new ScrollView(this);

        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(dp(18), dp(18), dp(18), dp(18));

        GradientDrawable card = new GradientDrawable();
        card.setColor(cardColor);
        card.setCornerRadius(dp(16));
        card.setStroke(dp(1), Color.rgb(43, 56, 80));
        content.setBackground(card);

        addSection(content, "1. Acceptance of Terms",
                "By downloading, accessing, or using TrustNet VPN, "
                + "you agree to these Terms of Service. If you do not "
                + "agree, do not use the application.");

        addSection(content, "2. About TrustNet VPN",
                "TrustNet VPN is an application designed to help users "
                + "manage VPN connections through supported and configured "
                + "servers. Available functionality may depend on your "
                + "device, internet connection, and server availability.");

        addSection(content, "3. Eligibility",
                "You must be legally permitted to use the app in your "
                + "jurisdiction. If you are a minor, use the app only "
                + "with any consent or supervision required by applicable law.");

        addSection(content, "4. Acceptable Use",
                "You agree not to use TrustNet VPN to violate applicable "
                + "laws, infringe the rights of others, distribute malware, "
                + "conduct unauthorized access, or interfere with the "
                + "operation or security of any service.");

        addSection(content, "5. VPN Connections",
                "A successful connection requires a functioning VPN server, "
                + "a valid configuration, and internet access. Selecting "
                + "a country or server name does not guarantee that a "
                + "working server is available. Connection speed and "
                + "reliability may vary.");

        addSection(content, "6. Privacy and Security",
                "Your use of the app is also subject to our Privacy Policy. "
                + "A VPN can help route network traffic through a VPN "
                + "server, but it does not guarantee complete anonymity, "
                + "protection from every threat, or uninterrupted security.");

        addSection(content, "7. Third-Party Services",
                "The app may rely on third-party services, server providers, "
                + "payment processors, or advertising and analytics providers "
                + "where applicable. Their services may be governed by "
                + "separate terms and privacy policies.");

        addSection(content, "8. Subscriptions and Payments",
                "If paid features or subscriptions are offered, pricing, "
                + "billing periods, renewal, cancellation, and refund "
                + "conditions will be presented through the applicable "
                + "purchase flow and governed by the relevant store "
                + "and payment provider rules.");

        addSection(content, "9. Service Availability",
                "We may update, modify, suspend, or discontinue features "
                + "as permitted by applicable law. We do not guarantee "
                + "that the service will always be available, error-free, "
                + "or compatible with every device or network.");

        addSection(content, "10. Disclaimer",
                "To the extent permitted by applicable law, the app is "
                + "provided on an as-available basis without guarantees "
                + "that every connection, server, or feature will operate "
                + "without interruption. Nothing in these terms removes "
                + "rights that cannot legally be excluded.");

        addSection(content, "11. Limitation of Liability",
                "To the extent permitted by applicable law, we are not "
                + "liable for indirect or consequential losses arising "
                + "from use of the app. Any limitation is subject to "
                + "mandatory legal rights and protections.");

        addSection(content, "12. Changes to These Terms",
                "We may revise these terms when our services or legal "
                + "obligations change. Updated terms will be published "
                + "with a revised effective date. Continued use after "
                + "changes take effect is subject to applicable law.");

        addSection(content, "13. Contact Us",
                "Developer: [Your developer or company name]\n"
                + "Email: YOUR_SUPPORT_EMAIL@example.com\n\n"
                + "Replace these placeholders with your actual contact "
                + "details before publishing.");

        scrollView.addView(content);

        root.addView(scrollView,
                new LinearLayout.LayoutParams(-1, 0, 1f));

        setContentView(root);
    }

    private void addSection(LinearLayout parent,
                            String heading, String body) {

        TextView headingView = new TextView(this);
        headingView.setText(heading);
        headingView.setTextColor(accentColor);
        headingView.setTextSize(18);
        headingView.setTypeface(null, Typeface.BOLD);
        headingView.setPadding(0, dp(18), 0, dp(6));
        parent.addView(headingView);

        TextView bodyView = new TextView(this);
        bodyView.setText(body);
        bodyView.setTextColor(textColor);
        bodyView.setTextSize(14);
        bodyView.setLineSpacing(dp(3), 1f);
        parent.addView(bodyView);
    }

    private int dp(float value) {
        return (int) (value * getResources()
                .getDisplayMetrics().density + 0.5f);
    }
}
