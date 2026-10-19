
package com.example.trustnetvpn; 

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PrivacyPolicyActivity extends AppCompatActivity {

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
        root.addView(backButton, new LinearLayout.LayoutParams(
                -1, dp(48)));

        backButton.setOnClickListener(v -> finish());

        TextView title = new TextView(this);
        title.setText("Privacy Policy");
        title.setTextColor(accentColor);
        title.setTextSize(28);
        title.setTypeface(null, Typeface.BOLD);
        title.setPadding(0, dp(14), 0, dp(4));
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("TrustNet VPN  \u2022  Last updated: October 19, 2026");
        subtitle.setTextColor(mutedColor);
        subtitle.setTextSize(13);
        subtitle.setPadding(0, 0, 0, dp(18));
        root.addView(subtitle);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(false);

        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(dp(18), dp(18), dp(18), dp(18));

        GradientDrawable cardBackground = new GradientDrawable();
        cardBackground.setColor(cardColor);
        cardBackground.setCornerRadius(dp(16));
        cardBackground.setStroke(dp(1), Color.rgb(43, 56, 80));
        content.setBackground(cardBackground);

        addSection(content, "1. Introduction",
                "TrustNet VPN respects your privacy. This policy explains "
                + "how information may be processed when you use the app.");

        addSection(content, "2. Information We Process",
                "Depending on the features you use, the app may process "
                + "device information, app diagnostics, connection status, "
                + "selected server, and information you submit through "
                + "account or support features. Only describe information "
                + "that your actual app collects or processes.");

        addSection(content, "3. VPN Connections",
                "TrustNet VPN uses Android VPN functionality to connect "
                + "to a configured VPN server. Depending on your server "
                + "and routing setup, network traffic may pass through "
                + "that server. The server or its hosting provider may "
                + "process connection metadata. Actual logging practices "
                + "must be confirmed and accurately disclosed.");

        addSection(content, "4. How Information Is Used",
                "Information may be used to provide VPN connectivity, "
                + "troubleshoot errors, maintain security, improve "
                + "reliability, provide support, and process purchases "
                + "where those features are available.");

        addSection(content, "5. Third-Party Services",
                "If integrated into the app, third-party providers may "
                + "support analytics, advertising, payments, crash "
                + "reporting, or VPN server infrastructure. List only "
                + "the providers actually used by TrustNet VPN.");

        addSection(content, "6. Advertising and Analytics",
                "If advertising or analytics SDKs are enabled, their "
                + "providers may process app usage, diagnostic data, "
                + "or device identifiers according to their configuration "
                + "and applicable privacy requirements.");

        addSection(content, "7. Sharing of Information",
                "Information may be shared with relevant service providers "
                + "to operate the app, deliver services, process payments, "
                + "provide support, or meet legal obligations. Disclose "
                + "the actual categories shared and the recipients.");

        addSection(content, "8. Security and Retention",
                "Appropriate measures are intended to protect information. "
                + "Information should be retained only as long as needed "
                + "for the stated purposes or as required by law. No "
                + "method of storage or transmission guarantees absolute "
                + "security.");

        addSection(content, "9. Your Privacy Rights",
                "Depending on applicable law, you may be able to request "
                + "access to, correction of, or deletion of personal "
                + "information. Contact the developer to submit a request.");

        addSection(content, "10. Children's Privacy",
                "TrustNet VPN does not intend to collect children's "
                + "personal information in violation of applicable law. "
                + "Contact the developer if you have a relevant concern.");

        addSection(content, "11. Policy Updates",
                "This policy may be updated when the app, services, "
                + "or legal requirements change. Publish an updated "
                + "version when your practices change.");

        addSection(content, "12. Contact Us",
                "Developer: [Your developer or company name]\n"
                + "Email: YOUR_SUPPORT_EMAIL@example.com\n\n"
                + "Replace these placeholders with valid contact details.");

        scrollView.addView(content);
        root.addView(scrollView, new LinearLayout.LayoutParams(
                -1, 0, 1f));

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
